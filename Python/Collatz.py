

def collatz():
    # Constants
    MAX = 100000000
    START = 1
    maxPath = 0
    maxStart = 0

    path = []
    lengthMap = {}
    keys = []
    paths = {}

    op = 0
    length = 0
    for i in range(START, MAX):
        path.clear()
        path.append(i)
        if op < 0:
            print(i)
            break
        op = i
        length = 1
        while op != 1:
            if paths.keys().__contains__(op):
                length += lengthMap[op]-1
                path = path[:-1] + paths[op]
                break
            if op%2 == 0:
                op = int(op/2)
                length += 1
            else:
                op *= 3
                op += 1
                length += 1
            path.append(int(op))
        keys.append(i)
        lengthMap[i] = length
        if length >= maxPath:
            maxPath = length
            maxStart = i
            print(f'{length} elements: ', path)


if __name__ == '__main__':
    collatz()
