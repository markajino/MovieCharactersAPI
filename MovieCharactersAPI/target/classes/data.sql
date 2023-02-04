insert into franchise(id, description, name)
VALUES (1000, 'FirstFranchise', 'Kami')
ON CONFLICT (id) DO NOTHING;

insert into movie (id, director, genre, movie_title, picture, release_year, trailer, franchise_id)
values (200, 'Kamran Abbasi', 'Horror', 'WrongTurn', 'picture_url', '2022-02-02', 'trailer_youtube_url',
        1000)
ON CONFLICT (id) DO NOTHING;


insert into movie (id, director, genre, movie_title, picture, release_year, trailer, franchise_id)
values (201, 'Imran Abbasi', 'Horror', 'WrongTurn2', 'picture_url', '2022-02-03', 'trailer_youtube_url',
        1000)
ON CONFLICT (id) DO NOTHING;


insert into character (id, alias, full_name, gender, picture)
values (1000, 'Kylo Ren', 'Ben Solo', 'male', 'picture_url')
ON CONFLICT (id) DO NOTHING;


insert into movie_characters(movie_id, character_id)
VALUES (200, 1000) ON CONFLICT (movie_id,character_id ) DO NOTHING;

insert into movie_characters(movie_id, character_id)
VALUES (201, 1000) ON CONFLICT (movie_id,character_id ) DO NOTHING;