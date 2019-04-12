'''

Write a function that lists any THREE elements sum to zero, from an array of integers.
We need all unique solutions. 

Example
Input: [-5, 1, 10, 2, 3]  // array of integers
Output: [[-5, -5, 10], [-5, 2, 3]]  // array of arrays

Notes:
1. The same element can be used multiple times.
2. Reorder inside subarray is the same solution: [-5, -5, 10] === [10, -5, -5]



'''
# Intutive but not optimal O(n^3)
# for i =0 to n
#     for j= 0 to n
#         for k = 0 to n
            # if a[i] + a[j] + a[k] ==0:
#             put it into set


# sort the input array -> a


     i    j   k
a = [-5, 1, 2, 3, 10] 
a1 = [-5, -5, 1, 2, 3, 10] 
Output: [[-5, -5, 10], [-5, 2, 3]]
out = [-5]

# for i = 0 to n
# j = i, k = n;
#  a[i] + a[j] + a[k] == 0
#  a[i] + a[j] + a[k] > 0
#  k --
#  a[i] + a[j] + a[k] < 0
# j++
# nLogn + n^2 -> O(n^2)



# Time complextity: O(n^2)
# Space : O(1) (Auxilary space)


# test_arr = [-2,-1, 0, 1, 2]
# n = 5
# [-2, 0, 2], [-1, 0, 1], [0, 0, 0], [-2 , 1, 1], [-1, 2, -1]
# output size = 5
# Output: ceil o


# If a number in the input is not 0. Then it can be repeat at most twice! 
# Output size: n/3 = O(n)
# Actually Yubin, giving it a second thought, Space would be 3n in the worst case!  = O(n)

# Thank you for your time. I really Appreciate it!

def tripletSumZero(arr):
    arr.sort() # nLogn
    n = len(arr)
    
    output = {}

    for i in range(0, n): 	
        j = i
        k = n - 1
        while j <= k: # to account for the fact a number can be utilized more than once for the output.
            curr_sum = arr[i] + arr[j] + arr[k]
            
            if curr_sum == 0: # Happy path          
                # Check if the curr output already exists in the output array
                # arr is sorted
                # [-5, -5, 10]
                # [10, -5, -5] - can never happen because arr is already sorted!
                
                
                # Approach 1 - O(n)
                # Total time complexity: nLogn + n^3 = O(n^3)
                # make use of a Hashset for you output.
                triplet = [arr[i], arr[j], arr[k]]
                if not output.contains(triplet): 
                    output.append(triplet)
                
                # Approach 2 - O(1)
                # Total time complexity: nLogn + n^2 = O(n^2)
                # If output is a HashSet:
                output.append(triplet)
                    
                
                j += 1
                
            	
            elif curr_sum > 0:
                k -= 1
            	
            else:
                j += 1
    			
    return output
        
    
    
    
    






