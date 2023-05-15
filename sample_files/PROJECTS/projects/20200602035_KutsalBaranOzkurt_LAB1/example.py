import sys

total = 0
for arg in sys.argv[1:]:
    total += int(arg)
print(total)
