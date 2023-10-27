# 제네릭과 컬렉션

[Difference between List, List<?>, List<T>, List<E>, and List<Object>](https://stackoverflow.com/questions/6231973/difference-between-list-list-listt-liste-and-listobject)

## 01 제네릭 클래스

- 제네릭 프로그래밍(generic programming): 다양한 종류의 데이터를 처리할 수 있는 클래스와 메소드를 작성하는 기법
    - 제네릭: 클래스를 정의할 때 클래스 안에서 사용되는 자료형을 구체적으로 명시하지 ㅇ낳고 T와 같이 기호로 적어두는 것.

      객체를 생성할 때 T 자리에 구체적인 자료형을 넣어주면 됨


### 이전 방법

- Object 타입 사용
    - 데이터를 꺼낼 때마다 항상 형변환을 해야 한다

### 제네릭을 이용한 방법

- 제내릭 클래스(generic class)는 타입을 변수로 표시
    - 타입 매개 변수(type parameter)

    ```java
    class Box<T> {
    	private T data;
    	public void set(T data) {this.data = data;}
    	public T get() {return data;}
    }
    
    Box<String> b = new Box<String>();
    Box<Integer> bb = new Box<Integer>();
    ```

    - int 대신 Integer 사용해야 됨
        - int는 클래스가 아닌 기초 자료형이기 때문

## 02. 제네릭 메소드

- 메소드에서도 타입 매개 변수를 사용한 제네릭 메소드를 정의할 수 있음

```java
public class MyArrayAlg {
	public static <T> T getLast(T[] a) {
		return a[a.length-1];
}

public class MayArrayTest {
	public static void main(String[] args){
		String[] language = {"a", "b", "c"};
		String last = MyArrayTest.getLast(language);
		System.out.println(last);
}
```

- 제네릭 메소드는 일반 메소드처럼 꺽쇠를 쓰지 않고 호출해도 된다

## 04. 제네릭과 상속

```java
Box<Number> box = new Box<Number>();
box.add(new Integer(10));
box.add(new Double(10.1));
```

하지만 `Box<Number>` 를 통째로 매개변수로 받는 메소드가 있다면 `Box<Integer>`, `Bop<Double>` 은 쓰지 못한다. `Box<Integer>`, `Bop<Double>` 는 Box<Number>의 자식 클래스가 아니기 때문이다

## 05. 와일드 카드

위의 문제를 해결하기 위해 와일드 카드를 사용. 어떤 타입이든지 나타낼 수 있다. 와일드 카드는 매개변수, 필드, 지역 변수의 타입을 나타내는 데 사용된다.

### 상한이 있는 와일드 카드

A의 자손 클래스들 표시는 `<? extends A>`로 한다. 만약 `List<? extends Number>` 라면 Integer, Double 등 자식 클래스에도 매칭된다.

### 제한없는 와일드 카드

단순히 ?로만 이루어진다. 이 ?는 모든 타입에 매치된다. `List<?>` 는 `List<Integer>`, `List<Number>` 둘 다 가능하다.

### 하한이 있는 와일드 카드

어떤 클래스의 조상 클래스를 나타낼 때 `<? super A>` 같은 문법을 사용한다. `List<? super Integer>` 는 `List<Integer>`, `List<Number>`, `List<Object>` 에 대해 모두 작동한다.

## 06. 컬렉션

컬렉션(collection)은 자바에서 자료 구조를 구현한 클래스들을 칭하는 용어이다. 자료구조(data structure)는 자료를 저장하기 위한 구조이다. 많이 사용되는 자료 구조는 리스트(list), 스택(stack), 큐(queue), 집합(set), 해쉬 테이블(hash table) 등이 있다.

### 컬렉션의 종류

인터페이스와 클래스 모두 java.util 패키지에 포함되어있다. 모두 컬렉션 라이브러리들은 모두 제네릭 기능을 지원한다.

| 인터페이스 | 설명 |
| --- | --- |
| Collection | 모든 자료구조의 부모 인터페이스로서 객체의 모임을 나타낸다. |
| Set | 집합(중복된 원소를 가지지 않는)을 나타내는 자료 구조 |
| List | 순서가 있는 자료 구조로 중복된 원소를 가질 수 있다. |
| Map | 키와 값들이 연관되어 있는 사전과 같은 구조 |
| Queue | 극장에서의 대기줄과 같이 들어온 순서대로 나가는 구조(FIFO) |

## 08. ArrayList

### List 인터페이스

리스트(List)는 순서를 가지는 요소들의 모임으로 중복된 요소를 가질 수 있다. 자바에서 리스트는 인터페이스인 List에 의하여 정의된다. 인터페이스 List는 ArrayList, LinkedList, Vector 등의 클래스에 의하여 구현된다.

### ArrayList

왜 배열 대신에 ArrayList를 사용할까? 배열의 문제점은 배열을 생성할 때 배열의 크기가 고정된다는 점이다. ArrayList는 저장되는 데이터의 개수에 따라 자동적으로 크기가 변경된다.

### ArrayList의 기본 연산

ArrayList는 타입 매개 변수를 가지는 제네릭 클래스로 제공된다. ArrayList를 생성하려면 타입 매개변수를 지정해야 한다.

```java
ArrayList<String> list = new ArrayList<>();

list.add("milk");
list.add("bread");  // 요소 추가
list.add(1, "apple"); // 인덱스 1에 apple 삽입
list.set(2, "grape");  // 특정한 위치의 원소를 바꾸려면 set tkdyd
list.remove(1);  // 인덱스 1의 원소를 삭제한다.
String s = list.get(1);  // ArrayList 객체에 저장된 객체를 가져오는 get 메소드
int index = list.indexOf("grape");  // 1이 반환된다
int index2 = list.lastIndexOf("milk");  // 검색을 거꾸로 한다
```

### iterator

java.util 패키지에 정의 되어 있는 Iterator 인터페이스를 구현하는 객체이다. iterator는 ArrayList 뿐만 아니라 모든 컬렉션에 적용할 수 있다.

| 메소드 | 설명 |
| --- | --- |
| hasNext() | 아직 방문하지 않은 원소가 있으면 true를 반환 |
| next() | 다음 원소를 반환 |
| remove() | 최근에 반환된 원소를 삭제한다 |

hasNext()로 다음에 원소가 있는지 확인하고 next로 다음 원소를 반환하도록 할 수 있다. for-each를 사용하면 더 쉽다.

## 09. LinkedList

ArrayList는 중간에서 데이터 삽입이나 삭제가 생긴다면 그 위치의 뒤에 있는 원소들을 이동해야 하는 문제가 있다. 이런 경우는 연결 리스트로 구현된 LinkedList가 성능이 더 낫다

LinkedList는 각 원소를 링크로 연결한다. 각 원소는 다음 원소를 가리키는 링크를 저장한다. 자바는 모든 연결 리스트가 이중 연결 리스트로 구현되어있어 이전 원소를 가리키는 링크도 가능하다.

중간에 삽입이나 삭제하려면 그 위치의 바로 앞에 있는 링크 값만 변경하면 된다.

단점은 인덱스를 가지고 접근하는 연산에서 시간이 많이 걸린다.

### iterator 사용하기

ArrayList나 LinkedList와 같은 리스트에서 사용하기 편한 iterator는 ListIterator이다. ListIterator는 previous(), hasPrevious()를 더 갖고 있는데 이들은 리스트를 역순으로 방문하는 경우에 사용한다.

### 배열을 리스트로 변경하기

`Arrays.asList()`는 배열을 받아서 리스트 형태로 반환한다.



```java
List<String> list = Arrays.asList(new String[size]);
```

## 10. Set

순서에 상관없이 원소만 저장할 때 Set을 사용한다. Set은 동일한 원소를 중복해서 가질 수 없다. Set은 hash table로 구현되어 있다.

Set 인터페이스에 대해 HashSet, TreeSet, LinkedHashSet 3가지의 구현이 제공된다. HashSet은 해쉬 테이블에 원소를 저장해 성능 면에서 우수하지만 원소들의 순서가 일정하지 않은 단점이 있다. TreeSet은 레드-블랙(red-black) 트리에 원소를 저장한다. 따라서 값에 따라 순서가 결정되지만 HashSet 보단 느리다. LinkedHashSet은 해쉬 테이블과 연결 리스트를 결합한것으로 원소들의 순서는 삽입되었던 순서와 같다.

### 예제

중복된 단어를 검출하는 프로그램

```java
public static void main(String[] args) {
    Set<String> s = new HashSet<>();
    String[] sample = {"단어", "중복", "구절", "중복"};
    for (String a: sample){
        if (!s.add(a))
            System.out.println("중복된 단어 "+a);
    }
    System.out.println(s.size()+"중복되지 않은 단어: "+s);

}
```

`boolean add(E e);` add의 return은 boolean이다.

### 대량 연산 메소드

집합에서 유용하다. s1, s2가 set이라고 하자

| s1.containsAll(s2) | 만약 s2가 s1의 부분 집합이면 참이다. |
| --- | --- |
| s1.addAll(s2) | s1을 s1과 s2의 합집합으로 만든다. |
| s1.retainAll(s2) | s1을 s1과 s2의 교집합으로 만든다. |
| s1.removeAll(s2) | s1을 s1과 s2의 차집합으로 만든다. |

## 11. Queue

queue는 데이터를 처리하기 전에 잠시 저장하고 있는 자료 구조이다. 큐는 tail에서 원소를 추가하고 head에서 원소를 삭제한다.

Deque는 head와 tail에서 모두 원소를 추가하거나 삭제할 수 있다. 중간에 원소를 추가하는 것은 허용되지 않는다 .Deque 인터페이스는 ArrayDeque와 LinkedList 클래스들로 구현된다

### Queue 인터페이스

기본적인 Collection의 연산 외에 다음 연산을 추가로 제공한다

```java
public interface Queue<E> extends Collection<E> {
    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and throwing an {@code IllegalStateException}
     * if no space is currently available.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     *         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    boolean add(E e);

    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue, else
     *         {@code false}
     * @throws ClassCastException if the class of the specified element
     *         prevents it from being added to this queue
     * @throws NullPointerException if the specified element is null and
     ***         this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue**
     */
    boolean offer(E e);

    /**
     * Retrieves and removes the head of this queue.  This method differs
     * from {@link #poll() poll()} only in that it throws an exception if
     * this queue is empty.
     *
     * @return the head of this queue
     *** @throws NoSuchElementException if this queue is empty**
     */
    E remove();

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     *** @return the head of this queue, or {@code null} if this queue is empty**
     */
    E poll();

    /**
     * Retrieves, but does not remove, the head of this queue.  This method
     * differs from {@link #peek peek} only in that it throws an exception
     * if this queue is empty.
     *
     * @return the head of this queue
     *** @throws NoSuchElementException if this queue is empty**
     */
    E element();

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     *** @return the head of this queue, or {@code null} if this queue is empty**
     */
    E peek();
}
```

### 우선순위 큐

Priority Queue

## 12. Map

원하는 데이터를 빠르게 찾을 수 있는 자료구조이다. 사전처럼 단어(key)가 있고 단어에 대한 설명(value)가 있다. 중복된 키를 가질 수 없고, 각 키는 하나의 값에만 매핑될 수 있다. Map 인터페이스를 구현한 클래스는 HashMap, TreeMap, LinkedHashMap등의 3가지 클래스가 있다. HashMap은 해싱 테이블에 데이터를 저장하고 TreeMap은 탐색 트리에 데이터를 저장한다.

`get()`, `put()`, `containsKey()`, `containsBalue()`, `size()`, `isEmpty()` 등의 연산이 있다.

## 13. Collections 클래스

Collections 클래스는 여러 유용한 알고리즘을 구현한 메소드들을 제공한다. 이 메소드들은 제네릭 기술을 사용해서 만들어졌으며 정적 메소드의 형태로 되어 있다

### 정렬

Collection 클래스의 sort() 메소드는 List 인터페이스를 구현하는 컬렉션에 대해 정렬을 수행한다.

### 탐색(Searching)

Collections 클래스의 binarySearch 알고리즘은 정렬된 리스트에서 이진 탐색한다. binarySearch()는 리트와 탐색할 원소를 받는다. 리스트는 정렬되어 있다고 가정한다.

### 기타 메소드

| min(), max() | 리스트에서 최대값과 최소값을 찾는다 |
| --- | --- |
| reverse() | 리스트의 원소들의 순서를 반대로 한다 |
| fill()  | 지정된 값으로 리스트를 채운다 |
| copy() | 목적 리스트와 소스 리스트를 받아서 소스를 목적지로 복사한다 |
| swap() | 리스트의 지정된 위치의 원소들을 서로 바꾼다. |
| addAll() | 컬렉션 안의 지정된 모든 원소들을 추가한다. |
| frequency()  | 지정된 컬렉션에서 지정된 원소가 얼마나 많이 등장하는지를 반환한다. |
| disjoint()  | 두 개의 컬렉션이 겹치지 않는지를 검사한다 |