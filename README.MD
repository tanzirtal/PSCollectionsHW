#####PluralSite Java SE 17 Notes#####

1.	What are Collections and why should you use them?
a.	Why should you use collections?
i.	Certain operations are very code heavy with regular array objects, and are made easier with different types of collections. EX: can sort easier with .sort() method than writing it out for a simple array
b.	Which collection should you use and why?

 

 
i.	Collection interface – where all collections extend from (subclass of Collection)
1.	Types of Collections(Interfaces of collection):
a.	List
i.	ArrayList
ii.	LinkedList
b.	Set
i.	HashSet
c.	SortedSet
i.	TreeSet
d.	Queue
i.	PriorityQueue
e.	Deque
i.	LinkedList
ii.	ArrayDeque
f.	Map
i.	HashMap
g.	SortedMap
i.	TreeMap

c.	APIs and behaviors
i.	Collection extends the Iterable interface, needs it to create Iterator object
ii.	Has these methods in common with all collections
1.	size()
a.	Number of elements in a collection
2.	isEmpty()
a.	True is size() == 0, false otherwise
3.	add()
a.	Ensure that an element is in the collection
4.	addAll()
a.	Add all the elements of the argument collection to this collection
5.	remove(element)
a.	Remove the element from this collection
6.	removeAll(collection)
a.	Remove all the elements of the argument collection to this collection
7.	retainAll(collection)
a.	Remove all the elements of this collection not in the argument collection
8.	contains(element)
a.	True if the element is in this collection, false otherwise
9.	containsAll(collection)
a.	True if all the elements of the argument collection are in this collection
10.	clear()
a.	Remove all elements from this collection
2.	Collections with Iteration Order: Lists
a.	Key Features of Lists
i.	Lists are collections with iteration orders.
1.	Unless you modify the index of the List, they will output the same everytime. Once you modify the index in any way (methods outlined below) then everything AFTER that index will become shuffled
a.	void add(int index, E e);
b.	E get(int index);
c.	E remove(int index);
d.	E set(int index, E element);
e.	boolean addAll(int index, Collection c);
2.	Lookup indices by value:
a.	int indexOf(Object o);
b.	int lastIndexOf(object o);
3.	Sublist
a.	Views over ranges of lists. Modifying the view modifies the list
b.	List subList(int fromIndex, int toIndex);
c.	list.sort(Comparator<? Super E> comparator)
4.	Static factory methods, creates unmodifiable list instances. Throws exception if you try to modify
a.	List<E> of()
b.	List <E> of(E e1)
c.	List<E> of(E e1, E e2)
i.	Takes from 0-10 arguments
d.	List<E> of(E … elements)
i.	Varargs constructor for more than 10 arguments
e.	List<E> copyOf(Collection<E>)
i.	Creates an unmodifiable copy of an existing collection. Shallow copy, takes value not underlying elements
b.	Demo
i.	See intellij java file (3)
c.	Implementations
i.	List interface
1.	ArrayList
a.	Great general purpose implementation
b.	Use as default vs LinkedList. 
c.	CPU Cache sympathetic, this means that to optimize code use arrays because they are CPU cache friendly
2.	LinkedList

a.	Headnodes & tailnodes
b.	Pointer to tell what each element is
c.	Worst performance in most cases
d.	Implements queue interface, use when adding elements to the start or when adding/removing a lot of elements
d.	Implementation Performance
i.	Big O notation  https://www.bigocheatsheet.com
3.	Storing Key/Value Pairs: Maps
a.	Why Use a Map
i.	In some applications, basically in Big O notation, it becomes O(n) in time complexity.
ii.	When adding products and looking them up, using a hashmaps key value pairs can result in 100x faster output than arraylists. MORE EFFICIENT
b.	Map API
i.	Adding and replacing values
1.	V put(K key, V value)
a.	Adds single value to map
2.	void putAll(Map<? extends K, ? extends V>  values)
a.	Adds a whole other Map to map
ii.	Looking up elements
1.	V get(Object key)
2.	boolean containsKey(Object key)
3.	boolean containsValue(Object value)


iii.	Removing elements
1.	V remove(Object key)
a.	Removes single element, identified by key
2.	Void clear()
a.	Removes all elements
iv.	Querying size
1.	int size()
a.	total number of elements
2.	boolean isEmpty()
a.	is map empty or not?
v.	Immutable Map Factories
1.	Map.Entry<String , Integer> entry = Map.entry(“Tanzir”, 27);
a.	Creates instance of KV pair
2.	Map<String, Integer> personToAge = Map.of(“Tanzir”, 27);
a.	Creates up to 10 overloads
3.	personToAge = Map.ofEntries(Map.entry(“Tanzir”, 27));
a.	Takes >10 values to take more elements
4.	Map<String , Integer> copy = Map.copyOf(personToAge);
a.	Immutable copies of an existing map.
vi.	Map is the only collections that don’t extend or implement the Collection interface
c.	Views over Maps
i.	See IntelliJ code
d.	Advanced Operations
i.	Altering and removing values
1.	replace(key, value)
a.	Update a single value
2.	replaceAll(BiFunction<K, V, V>)
a.	Replace elements using a function
3.	remove(key, value)
a.	Remove a key only if it has a value
ii.	Updating the map
1.	getOrDefault
2.	computeIfAbsent
3.	putIfAbsent
a.	If value isn’t already there, or if key value is null
4.	computeIfPresent
5.	compute
a.	if value is present, will give value
6.	merge


iii.	forEach()
1.	Convenient callback based iteration
a.	Because there is not an easy way to iterate without using the iterator() method, this was implemented to circumvent
e.	Advanced Operations Demo
i.	See intellij code
f.	Implementations
i.	HashMap
1.	Good general purpose implementation
2.	Uses the .hashCode() method
3.	Maintains an array of buckets
4.	Rehash(hash) %bucket_count – defines a slot within the array
5.	Buckets are linked lists to accommodate collisions
6.	Buckets can be trees
7.	Number of buckets increases with more elements
ii.	TreeMap
1.	Defines sort order and adds functionality
2.	Comparator
a.	Key elements have a sort order
3.	Red/Black Tree
a.	Balanced binary tree
4.	Navigable & Sorted
a.	Provides functionalities that HashMaps don’t have, at the cost of speed
iii.	LinkedHashMap
1.	Useful when implementing Size based caches
2.	Maintains Order, either insertion or access
3.	removeEldesEntry, subclass and Override method in order to control cache
iv.	IdentityHashMap
1.	Use for serialization or Graphs
2.	Faster & Lower memory
3.	Low Collission likelihood
4.	Violates map contract




v.	WeakHashMap
1.	Useful for a memory bounded cache
2.	Keys have weak references, can be collected if nothing else references them
3.	Entries can be removed after the key is collected
vi.	EnumMap
1.	Keys are enums, faster and low memory usage
2.	Bitset implementation, only a single long if <64 elements
g.	Special Purpose Implementations
i.	See above 
4.	Collections with Uniqueness: Sets
Sets are collections of distinct elements. There are NO duplicates
a.	Set Features
i.	Look at IntelliJ code
b.	Hashcode and Equals
i.	Hashcode/Equals contract
1.	If your object equals another object, hashcode should be equal as well
ii.	Equality
1.	Can be reference based or value based. Reference based just needs to inherit equals from Object. Value based requires a custom equals method.
c.	Set Implementations
i.	HashSet
1.	Based upon HashMap, uses hashcode() and looks up location
2.	Good general purpose implementation, use by default
ii.	TreeSet
1.	Based upon TreeMap
2.	Uses Red/Black binary tree with defined sort order
3.	Provides extra features, implements SortedSet and NavigableSet
iii.	LinkedHashSet
1.	Use when Copying Set to modify or Deduping List or Queue
2.	Maintains order, only insertion
3.	Overhead, slower than HashSet, uses less memory than TreeSet
iv.	EnumSet
1.	Keys are enums, faster low memory usage
2.	Bitset implementation only a single long <64 elements




d.	SortedSet and NavigableSet
i.	SortedSet
1.	Defines an order
a.	first()
b.	last()
c.	SortedSet tailSet(E fromElement);
d.	SortedSet headset(E fromElement);
e.	SortedSet subset(E fromElement, E toElement);
ii.	NavigableSet
1.	Extends SortedSet
2.	Implemented by TreeSet
3.	Provides ways to move through the order
a.	E lower(E e);
b.	E higher(E e);
c.	E floor(E e);
d.	E ceiling(E e);
e.	E pollFirst();
f.	E pollLast();


