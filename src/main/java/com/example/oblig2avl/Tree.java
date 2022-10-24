package com.example.oblig2avl;

import java.util.Collection;

public interface Tree<E> extends Collection<E> {
    public boolean search(E e);
    public boolean insert(E e);
    public boolean delete(E e);
    public int getSize();

    public default void inorder() {

    }

    public default void postorder() {

    }

    public default void preorder() {

    }

    @Override
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public default boolean contains(Object e) {
        return search((E)e);
    }

    @Override
    public default boolean add(E e) {
        return insert(e);
    }

    @Override
    public default boolean remove(Object e) {
        return delete((E)e);
    }

    @Override
    public default int size() {
        return getSize();
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        return containsAll(c);
    }

    @Override
    public default boolean addAll(Collection<? extends E> c) {
        return addAll(c);
    }

    @Override
    public default boolean removeAll(Collection<?> c) {
        return removeAll(c);
    }

    @Override
    public default boolean retainAll(Collection<?> c) {
        return retainAll(c);
    }

    @Override
    public default Object[] toArray() {
        return toArray();
    }

    @Override
    public default <T> T[] toArray(T[] array) {
        return (T[]) toArray();
    }

}
