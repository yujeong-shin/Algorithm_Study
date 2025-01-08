import sys
input = sys.stdin.readline

money = int(input())
stocks = list(map(int, input().split()))

jh_count = 0
jh_money = money
sm_count = 0
sm_money = money

for stock in stocks:
    if stock <= jh_money:
        jh_count += jh_money // stock
        jh_money -= jh_count * stock
    
for i in range(3, len(stocks)):
    if stocks[i-3] > stocks[i-2] and stocks[i-2] > stocks[i-1] and stocks[i-1] > stocks[i]:
        if stocks[i] <= sm_money:
            sm_count += sm_money // stocks[i]
            sm_money -= sm_count * stocks[i]
    elif stocks[i-3] < stocks[i-2] and stocks[i-2] < stocks[i-1] and stocks[i-1] < stocks[i]:
        if sm_count > 0:
            sm_money += sm_count * stocks[i]
            sm_count = 0

last_stock_price = stocks[len(stocks)-1]
jh_result = jh_count * last_stock_price + jh_money
sm_result = sm_count * last_stock_price + sm_money
if jh_result > sm_result:
    print("BNP")
elif jh_result < sm_result:
    print("TIMING")
else:
    print("SAMESAME")