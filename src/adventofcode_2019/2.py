def run_program(program):
    ip = 0 # instruction pointer
    op = program[ip] # operation code
    while op != 99:
        if op == 1:
            p1 = program[ip+1] # pointer to first value
            p2 = program[ip+2] # pointer to second value
            p3 = program[ip+3] # pointer to result
            program[p3] = program[p1] + program[p2] # do the op
            ip = ip + 4 # move the instruction pointer
        elif op == 2:
            p1 = program[ip+1]
            p2 = program[ip+2]
            p3 = program[ip+3]
            program[p3] = program[p1] * program[p2]
            ip = ip + 4 # move the instruction pointer
        elif op != 99:
            print("Invalid instruction!", op)
            exit(1)
        op = program[ip] # next op code
    return program[0] # Return the value left at position 0

def main():
    global input
    program = [int(x) for x in input.split(",")]
    # sanitize before running!
    for i in range(100):
        for j in range(100):
            program[1] = i
            program[2] = j
            result = run_program(program.copy())
            if result == 19690720:
                print("i", i, "j", j)
                print(100 * i + j)
                exit(0)
    print("no inputs found that result in the desired result")

input = """1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,2,19,6,23,2,13,23,27,1,9,27,31,2,31,9,35,1,6,35,39,2,10,39,43,1,5,43,47,1,5,47,51,2,51,6,55,2,10,55,59,1,59,9,63,2,13,63,67,1,10,67,71,1,71,5,75,1,75,6,79,1,10,79,83,1,5,83,87,1,5,87,91,2,91,6,95,2,6,95,99,2,10,99,103,1,103,5,107,1,2,107,111,1,6,111,0,99,2,14,0,0"""

if __name__=="__main__":
    main()
