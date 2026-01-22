def solution(genres, plays):
    answer = []
    plyCntByGenre = {}
    songsByGenre = {}
    
    for song, genre in enumerate(genres):
        if genre in plyCntByGenre.keys():
            plyCntByGenre[genre] += plays[song]
            songsByGenre[genre].append(song)
        else:
            plyCntByGenre[genre] = plays[song]
            songsByGenre[genre] = [song]
    
    sortedGenre = sorted(plyCntByGenre, key=lambda x:plyCntByGenre[x], reverse=True)
    for genre in sortedGenre:
        sortedSongs = sorted(songsByGenre[genre], key=lambda x:plays[x], reverse=True)
        answer.append(sortedSongs[0])
        if len(sortedSongs) >= 2:
            answer.append(sortedSongs[1])
    
    return answer