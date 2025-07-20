1. For Pascal's Triangle, if they ask what will be the rth element in nth row, it's always (n-1)C(r-1)


2. Time complexity is a way to describe how the running time of an algorithm increases as the input size grows.

🔍 Formal Definition:
Time complexity is a function that gives the number of basic operations (such as comparisons or assignments) an algorithm performs as a function of the input size n.

✅ Why it's important:
It helps compare the efficiency of algorithms.

It tells you how well an algorithm scales with larger inputs.

⚡ Common Time Complexities:
Notation	Name	Example
O(1)	Constant	Accessing an element in an array
O(log n)	Logarithmic	Binary search
O(n)	Linear	Loop through an array
O(n log n)	Log-linear	Efficient sorting algorithms (Merge Sort)
O(n²)	Quadratic	Nested loops (e.g., Bubble Sort)
O(2ⁿ)	Exponential	Recursive Fibonacci
Hashing -> Prestoring + fetching
Selection Sort -> Select Minimum and Swap
Bubble Sort -> compare neighbours and swap
Insertion Sort -> compare all and place the min
Merge Sort -> Divide and Merge