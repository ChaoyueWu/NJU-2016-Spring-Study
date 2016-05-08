import java.util.*;
/*
 * @(#)DoubleLinkedList.java	1.46 03/01/23
 *
 * Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */


/**
 * Linked list implementation of the <tt>List</tt> interface. Implements all
 * optional list operations, and permits all elements (including <tt>null</tt>).
 * In addition to implementing the <tt>List</tt> interface, the
 * <tt>DoubleLinkedList</tt> class provides uniformly named methods to
 * <tt>get</tt>, <tt>remove</tt> and <tt>insert</tt> an element at the beginning
 * and end of the list. These operations allow linked lists to be used as a
 * stack, queue, or double-ended queue (deque).
 * <p>
 *
 * All of the stack/queue/deque operations could be easily recast in terms of
 * the standard list operations. They're included here primarily for
 * convenience, though they may run slightly faster than the equivalent List
 * operations.
 * <p>
 *
 * All of the operations perform as could be expected for a doubly-linked list.
 * Operations that index into the list will traverse the list from the begining
 * or the end, whichever is closer to the specified index.
 * <p>
 *
 * <b>Note that this implementation is not synchronized.</b> If multiple threads
 * access a list concurrently, and at least one of the threads modifies the list
 * structurally, it <i>must</i> be synchronized externally. (A structural
 * modification is any operation that adds or deletes one or more elements;
 * merely setting the value of an element is not a structural modification.)
 * This is typically accomplished by synchronizing on some object that naturally
 * encapsulates the list. If no such object exists, the list should be "wrapped"
 * using the Collections.synchronizedList method. This is best done at creation
 * time, to prevent accidental unsynchronized access to the list:
 *
 * <pre>
 *     List list = Collections.synchronizedList(new DoubleLinkedList(...));
 * </pre>
 * <p>
 *
 * The iterators returned by the this class's <tt>iterator</tt> and
 * <tt>listIterator</tt> methods are <i>fail-fast</i>: if the list is
 * structurally modified at any time after the iterator is created, in any way
 * except through the Iterator's own <tt>remove</tt> or <tt>add</tt> methods,
 * the iterator will throw a <tt>ConcurrentModificationException</tt>. Thus, in
 * the face of concurrent modification, the iterator fails quickly and cleanly,
 * rather than risking arbitrary, non-deterministic behavior at an undetermined
 * time in the future.
 *
 * <p>
 * Note that the fail-fast behavior of an iterator cannot be guaranteed as it
 * is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification. Fail-fast iterators throw
 * <tt>ConcurrentModificationException</tt> on a best-effort basis. Therefore,
 * it would be wrong to write a program that depended on this exception for its
 * correctness: <i>the fail-fast behavior of iterators should be used only to
 * detect bugs.</i>
 * <p>
 *
 * This class is a member of the <a href="{@docRoot}
 * /../guide/collections/index.html"> Java Collections Framework</a>.
 *
 * @author Josh Bloch
 * @version 1.46, 01/23/03
 * @see List
 * @see ArrayList
 * @see Vector
 * @see Collections#synchronizedList(List)
 * @since 1.2
 */

public class DoubleLinkedList {

    protected transient int modCount = 0;
    private transient Entry header = new Entry(null, null, null);
    private transient int size = 0;

    public DoubleLinkedList() {
        header.next = header.previous = header;
    }

    public DoubleLinkedList(Collection c) {
        this();
        addAll(c);
    }

    
    boolean repOK() {
        if (header == null) {
            return false;
        }
        Entry tmp = header;
        int i = 0;
        do {
            if (!tmp.nonNullPointers() || !tmp.repOK()) {
                return false;
            }
            tmp = tmp.next;
            if (tmp != header) {
                i++;
            }
        } while (tmp != header);
        tmp = header;
        return i == size;
    }

    boolean inList(Entry e) {
        if (header == e) {
            return true;
        }
        Entry tmp = header.next;
        while (tmp != header) {
            if (tmp == e) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public int size() {
        return size;
    }

    public boolean add(Object o) {
        addBefore(o, header);
        return true;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Entry e = header.next; e != header; e = e.next) {
                if (e.element == null) {
                    remove(e);
                    return true;
                }
            }
        } else {
            for (Entry e = header.next; e != header; e = e.next) {
                if (o == e.element) {
                    remove(e);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addAll(Collection c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        modCount++;

        Entry successor = (index == size ? header : entry(index));
        Entry predecessor = successor.previous;
        for (int i = 0; i < numNew; i++) {
            Entry e = new Entry(a[i], successor, predecessor);
            predecessor.next = e;
            predecessor = e;
        }
        successor.previous = predecessor;

        size += numNew;
        return true;
    }

    public void clear() {
        modCount++;
        header.next = header.previous = header;
        size = 0;
    }

    public Object get(int index) {
        return entry(index).element;
    }

    public void add(int index, Object element) {
        addBefore(element, (index == size ? header : entry(index)));
    }

    public Object remove(int index) {
        Entry e = entry(index);
        remove(e);
        return e.element;
    }

    private Entry entry(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
                                                + size);
        Entry e = header;
        for (int i = 0; i <= index; i++)
            e = e.next;

        return e;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Entry e = header.next; e != header; e = e.next) {
                if (e.element == null)
                    return index;
                index++;
            }
        } else {
            for (Entry e = header.next; e != header; e = e.next) {
                if (o == e.element)
                    return index;
                index++;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int index = size;
        if (o == null) {
            for (Entry e = header.previous; e != header; e = e.previous) {
                index--;
                if (e.element == null)
                    return index;
            }
        } else {
            for (Entry e = header.previous; e != header; e = e.previous) {
                index--;
                if (o == e.element)
                    return index;
            }
        }
        return -1;
    }
  
    private static class Entry {
        Object element;
        Entry next;
        Entry previous;

        Entry(Object element, Entry next, Entry previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
        
        boolean nonNullPointers() {
            return next != null && previous != null;
        }

        boolean repOK() {
            return next.previous == this;
        }

    }

    //@ requires inList(e);
    private Entry addBefore(Object o, Entry e) {
        Entry newEntry = new Entry(o, e, e.previous);
        newEntry.previous.next = newEntry;
        newEntry.next.previous = newEntry;
        size++;
        modCount++;
        return newEntry;
    }

    private void remove(Entry e) {
        if (e == header)
            throw new NoSuchElementException();

        e.previous.next = e.next;
        e.next.previous = e.previous;
        size--;
        modCount++;
    }

    public Object[] toArray(Object a[]) {
        if (a.length < size)
            a = (Object[]) java.lang.reflect.Array.newInstance(a.getClass()
                    .getComponentType(), size);
        int i = 0;
        for (Entry e = header.next; e != header; e = e.next)
            a[i++] = e.element;

        if (a.length > size)
            a[size] = null;

        return a;
    }

   
}
