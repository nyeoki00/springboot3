-- INSERT INTO article(id, title, content) VALUES (1, 'aaaa', '1111');
-- INSERT INTO article(id, title, content) VALUES (2, 'bbbb', '2222');
-- INSERT INTO article(id, title, content) VALUES (3, 'cccc', '3333');

INSERT INTO article(title, content) VALUES ('aaaa', '1111');
INSERT INTO article(title, content) VALUES ('bbbb', '2222');
INSERT INTO article(title, content) VALUES ('cccc', '3333');


INSERT INTO article(title, content) VALUES ('당신의 인생 영화는?', '댓글 고');
INSERT INTO article(title, content) VALUES ('당신의 소울푸드는?', '댓글 고고');
INSERT INTO article(title, content) VALUES ('당신의 취미는?', '댓글 고고고');


INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Park', '굿 윌 헌팅');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Kim', '아이 엠 샘');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Choi', '쇼생크 탈출');

INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Park', '치킨');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Kim', '샤브샤브');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Choi', '초밥');

INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Park', '조깅');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Kim', '유튜브 시청');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Choi', '독서');


INSERT INTO coffee(name, price) VALUES ('아메리카노', '4500');
INSERT INTO coffee(name, price) VALUES ('라떼', '5000');
INSERT INTO coffee(name, price) VALUES ('카페 모카', '5500');
