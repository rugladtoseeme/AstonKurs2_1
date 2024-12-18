package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Предоставляет функционал работы с коллекцией. ☕
 *
 * @param <E> Описывает тип хранимых в списке значений.
 */
public class ArrayList_BogolepovaLyudmila<E>  implements IntensiveList{

    private int size;
    private Object[] elements;
    private boolean isSorted;

    public ArrayList_BogolepovaLyudmila()
    {
        elements = (E[]) new Object[10];
        isSorted = false;
    }

    /**
     * Возвращает значение текущего размера динамического списка. ☕
     *
     * @return Текущий размер динамического списка.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Добавляет элемент в динамический список в конец. ☕
     *
     * @param element Объект, добавляемый в динамический список.
     */
    @Override
    public void add(Object element) {
        if (size >= elements.length-1)
        {
            reSize();
        }

        elements[size] = element;
        isSorted = false;
        size++;
    }

    /**
     * Добавляет в список элемент на определенную позицию. ☕
     *
     * @param index Позиция, на которую будет добавлен элемент.
     * @param element Добавляемый объект.
     */
    @Override
    public void add(int index, Object element) {

        if (size >= elements.length-1)
        {
            reSize();
        }

        Object[] newArr = (E[]) new Object[elements.length+1];

        for (int i = 0; i < index; i++)
        {
            newArr[i] = elements[i];
        }

        newArr[index] = element;

        for (int i = index+1; i < elements.length; i++){
            newArr[i] = elements[i-1];
        }

        elements = newArr;
        isSorted = false;
        size++;
    }

    /**
     * Получает элемент списка по его индексу. ☕
     *
     * @param index Индекс в списке, по которому должен быть получен элемент.
     * @return Элемент, находящийся по заданному индексу.
     */
    @Override
    public Object get(int index) {
        if (index >= 0 && index < size)
            return elements[index];
        else {
            System.out.println("invalid index");
            return new Object();
        }
    }

    /**
     * Устанавливает новое значение для элемента с определенным индексом. ☕
     *
     * @param index Позиция, на которой находится заменяемый объект
     * @param element Заменяемый объект.
     * @return Новое значение элемента под заданным индексом.
     */
    @Override
    public Object set(int index, Object element) {
        if (index >= 0 && index < size)
            elements[index] = element;
        else System.out.println("invalid index");
        isSorted = false;
        return elements[index];
    }

    /**
     * Удалеяет элемент с определенным индексом. ☕
     *
     * @param index Индекс удаляемого элемента.
     * @return Значение удаляемого элемента.
     */
    @Override
    public Object remove(int index) {
        Object[] newArr = (E[]) new Object[elements.length-1];
        Object removedElem = elements[index];

        for (int i = 0; i < index; i++)
        {
            newArr[i] = elements[i];
        }

        for (int i = index; i < elements.length-1; i++){
            newArr[i] = elements[i+1];
        }

        elements = newArr;
        size--;
        return removedElem;
    }

    /**
     * Удаляет все элементы списка.
     */
    @Override
    public void clear() {
        Object[] newArr = (E[]) new Object[10];
        elements = newArr;
        size=0;
        isSorted = false;
    }

    /**
     * Осуществляет сортировку списка методом быстрой сортировки. ☕
     *
     * @param comparator Компаратор, обеспечивающий сравнение элементом списка.
     */
    @Override
    public void quickSort(Comparator comparator) {
        quickSortAlg(0, size-1, comparator);
        isSorted = true;
    }

    private void quickSortAlg(int low, int high, Comparator comparator){
        if (low < high) {
            int mid = partition(low, high, comparator);
            quickSortAlg(low, mid-1, comparator);
            quickSortAlg(mid+1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator comparator)
    {
        int middle = low + (high - low) / 2;
        Object pivot = elements[middle];

        Object temp = elements[middle];
        elements[middle] = elements[high];
        elements[high] = temp;

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(pivot, elements[j]) > 0) {
                i++;
                temp = elements[i];
                elements[i] = elements[j];
                elements[j] = temp;
            }
        }

        temp = elements[i + 1];
        elements[i + 1] = elements[high];
        elements[high] = temp;

        return i + 1;

    }

    private void swapElems(int index1, int index2)
    {
        if (index1 > 0 && index1 < size && index2 > 0 && index2 < size) {
            Object temp = elements[index1];
            elements[index1] = elements[index2];
            elements[index2] = temp;
        }
    }

    /**
     * Определяет, отсортирован список или нет. ☕
     *
     * @return .
     */
    @Override
    public boolean isSorted() {
        return isSorted;
    }

    /**
     * Обрезает список до заданного размера. ☕
     *
     * @param size Размер, до которого будет обрезан список.
     */
    @Override
    public void split(int size) {
        Object[] newArr = (E[]) new Object[size];
        this.size=size;

        for (int i = 0; i < size; i++)
        {
            newArr[i] = elements[i];
        }

        elements = newArr;
    }

    private void reSize()
    {
        Object[] arrCopy = elements;
        elements = (E[]) new Object[elements.length*2];

        for (int i = 0; i < arrCopy.length; i++)
        {
            elements[i] = arrCopy[i];
        }

    }

    @Override
    public String toString() {
        return "ArrayList_BogolepovaLyudmila{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                ", isSorted=" + isSorted +
                '}';
    }
}
