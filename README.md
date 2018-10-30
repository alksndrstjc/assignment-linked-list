# assignment-linked-list

PROBLEM: Determine the length of the reference loop in a singly-linked list.

SOLUTION: Proposed solution applies Floyd's cycle detection algorithm which can solve this problem in O(n).

This problem can be broken down into 2 steps: 1) determining whether the loop exists and 2) determining the length of the loop.

1) Determining the presence of the loop

In order to find whether or not the loop exists we can employ two pointers, let's call them 'walker' and 'jumper'.
We point these two pointers at the head of the linked list. We move walker by one node at a time, while jumper moves by two nodes at a time.
There are two possible alternatives - the jumper will either reach the end of the linked list or the pointers will meet at the same node at a specific moment.
The latter indicates that the loop is present.

NB - Floyd's algorithm can also help us detect the node out of which the loop starts. But it's not a requirement for the given problem.

2) Determining the length of the loop

If the loop is present, that is if the pointers have met at a certain node, 
all that remains to be done is to move either of them one node at a time and count passes until the pointers meet again.
Number of passes determines the loop's length.

app flow:
1) initialize a linked list with a reference loop on the node 5
2) determine the presence of the loop
3) if loop is not present return -1 else count passes 

