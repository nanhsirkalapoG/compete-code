# Find out the maximum absolute difference of any number
# such that | arr[i] - arr[j] | + | i - j | should be maximum value

# F(i, j) == F(j, i) where F(i, j) = | arr[i] - arr[j] | + | i - j |
# So let's consider i < j cases

# Case1: arr[i] < arr[j]
# arr[j] - arr[i] + j - i
# (arr[j] + j) - (arr[i] + i)

# Case2: arr[i] > arr[j]
# arr[i] - arr[j] + j - i
# (arr[i] - i) - (arr[j] - j)

def max_absolute_difference(arr)
  x_max = y_max = -(2**(0.size * 8 -2))
  x_min = y_min = (2**(0.size * 8 -2) -1)
  for i in (0...arr.length)
    x_max = [x_max, arr[i] + i].max
    x_min = [x_min, arr[i] + i].min
    y_max = [y_max, arr[i] - i].max
    y_min = [y_min, arr[i] - i].min
  end
  
  [x_max - x_min, y_max - y_min].max
end

arr = [3,2,4,6,1,5]
answer = max_absolute_difference(arr)
