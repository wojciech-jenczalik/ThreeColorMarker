import matplotlib.pyplot as plt

green = [float(line.rstrip('\n')) for line in open('green.txt')]
yellow = [float(line.rstrip('\n')) for line in open('yellow.txt')]
red = [float(line.rstrip('\n')) for line in open('red.txt')]

green_x=[int(line.rstrip('\n')) for line in open('greenIndexes.txt')]
yellow_x=[int(line.rstrip('\n')) for line in open('yellowIndexes.txt')]
red_x=[int(line.rstrip('\n')) for line in open('redIndexes.txt')]

plt.plot(green_x,green, color='green', linewidth=0, marker='o', label='green')
plt.plot(yellow_x, yellow, color='yellow', linewidth=0, marker='x', label='yellow')
plt.plot(red_x, red, color='red', linewidth=0, marker='v', label='red')
plt.xlabel('Numer pakietu')
plt.ylabel('Odstęp pomiędzy pakietami [ms]')
plt.legend()
plt.savefig('graph.png')
plt.show()
