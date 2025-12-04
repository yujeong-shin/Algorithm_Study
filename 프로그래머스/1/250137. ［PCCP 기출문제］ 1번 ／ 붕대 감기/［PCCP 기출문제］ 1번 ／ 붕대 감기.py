def solution(bandage, health, attacks):
    answer = 0
    cur_time = 0
    cur_health = health
    for attack in attacks:
        if cur_health <= 0:
            return -1
        print("cur_health: " + str(cur_health))
        attack_time, attack_dmg = attack
        no_attack_time = attack_time - 1 - cur_time
        print("no_attack_time: " + str(no_attack_time))
        if no_attack_time >= bandage[0]: # Bonus
            cur_health += (no_attack_time*bandage[1])
            cur_health += (no_attack_time//bandage[0])*bandage[2]
        else:
            cur_health += (no_attack_time*bandage[1])
        cur_health = min(cur_health, health)
        
        cur_time = attack_time
        cur_health -= attack_dmg
    answer = cur_health
    
    if answer == 0:
        return -1
    else:
        return answer