-- 기존 데이터
INSERT INTO article(title, content) VALUES('가가가가', '1111');
INSERT INTO article(title, content) VALUES('나나나나', '2222');
INSERT INTO article(title, content) VALUES('다다다다', '3333');
-- article 테이블에 데이터 추가
INSERT INTO article(title, content) VALUES('당신의 인생 영화는?', '댓글 고');
INSERT INTO article(title, content) VALUES('당신의 소울 푸드는?', '댓글 고고');
INSERT INTO article(title, content) VALUES('당신의 취미는?', '댓글 고고고');
-- 4번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Park', '굿 윌 헌팅');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Kim', '아이 엠 샘');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Choi', '쇼생크 탈출');
-- 5번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Park', '치킨');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Kim', '샤브샤브');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Choi', '초밥');
-- 6번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Park', '조깅');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Kim', '유튜브 시청');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Choi', '독서');



INSERT INTO member(id, email, password) VALUES(1, 'aaa@aa.a', '1234');
INSERT INTO member(id, email, password) VALUES(2, 'bbb@aa.a', '1111');
INSERT INTO member(id, email, password) VALUES(3, 'ccc@aa.a', 'asdf');

-- 11장 셀프체크 데이터 추가
INSERT INTO coffee(name, price) VALUES('아메리카노', '4500');
INSERT INTO coffee(name, price) VALUES('라떼', '5000');
INSERT INTO coffee(name, price) VALUES('카페 모카', '5500');

-- 15장 셀프체크 데이터 추가
INSERT INTO pizza(name, price) VALUES('페퍼로니 피자', '25,900');
INSERT INTO pizza(name, price) VALUES('불고기 피자', '29,900');
INSERT INTO pizza(name, price) VALUES('고구마 피자', '30,900');
INSERT INTO pizza(name, price) VALUES('포테이토 피자', '27,900');
INSERT INTO pizza(name, price) VALUES('치즈 피자', '23,900');

-- 16장 셀프체크 데이터 추가
INSERT INTO group22(name) VALUES('H');

INSERT INTO team(group_id, name, image_url) VALUES(1, 'Porutugal', 'https://i.namu.wiki/i/vgtbFhAyVcUh5iSZgGa6oV2jNJUKLylCYTjzEw39lnwd007dI9ApwDSRAu_XRnATHU6B2vtgMpCes6qip2zf2qK1qb_oye7AqQO-izaUtHA.svg');
INSERT INTO team(group_id, name, image_url) VALUES(1, 'Ghana', 'https://i.namu.wiki/i/vgtbFhAyVcUh5iSZgGa6oep5jCtJjRP01THHCLogQCU_oooLo73tjmgXxc7ACFS7raeyUIFvTyvzhTShvEySxIFdwAwqWW_VD--4MmwvlHc.svg');
INSERT INTO team(group_id, name, image_url) VALUES(1, 'Uruguay', 'https://i.namu.wiki/i/vgtbFhAyVcUh5iSZgGa6oWtD0XnOkNLl19aq1BPTOfDVeLLUC9IkaCoUSeaTbsXrWEFFWTp0FlcAglx9tkX0w1mRoKLEJ9XzRlEeP1QvzZ8.svg');
INSERT INTO team(group_id, name, image_url) VALUES(1, 'Korea', 'https://i.namu.wiki/i/vgtbFhAyVcUh5iSZgGa6oaddeKfC0cRApQvmLFbaBZAk8_6ObzT_dI1vVJ-70U3KWObAYpppT4GX4skGGASA4VZoKlBtEhsly9kERp13Wk4.svg');
