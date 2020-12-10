-- （十一）班级活动管理系统
-- 	1描述：
-- 		要求实现一个能够对班级活动信息进行管理的系统。
-- 2要求：
-- （1）普通学生用户登录系统，查看新闻公告、发表留言、查看自己的积分
-- （2）班级委员用户登录系统，查看新闻公告、发布新闻公告、回复留言、学生积分
-- 管理、奖学金管理。
-- （3）系统管理员对学生、教师、班委用户的信息注册。
-- （4）三类用户对个人信息进行维护，如修改个人基本信息、修改密码等
#用户表
CREATE TABLE user (
                      id INT NOT NULL PRIMARY KEY auto_increment,
    #主键id
                      NAME CHAR (20),
    #用户名
                      sno CHAR (20),
    #学号
                      PASSWORD CHAR (100),
    #账号
                      stars INT DEFAULT 0,
    #积分
                      pn CHAR (20),
    #电话
                      gender TINYINT,
    # 性别 1 男 0 女
                      email CHAR (30),
    #邮箱
                      rank_id INT DEFAULT 1
    #等级默认普通用户

);

#权限表
CREATE TABLE rank (
                      id INT NOT NULL PRIMARY KEY auto_increment,
    #主键id
                      rank TINYINT,
    #等级 1 普通用户 2 班级委员 3 系统管理员
                      info CHAR (30) #具体权限信息
);

INSERT INTO rank (id, `rank`, info)
    VALUE
    (1, 1, '普通用户');

INSERT INTO rank (id, `rank`, info)
    VALUE
    (2, 2, '班级委员');

INSERT INTO rank (id, `rank`, info)
    VALUE
    (3, 3, '系统管理员');

#日志表 用于记录班级委员加减积分
CREATE TABLE log(
                    id INT NOT NULL PRIMARY KEY auto_increment,
    #主键
                    info VARCHAR (200),
    #加减分原因
                    flag TINYINT,
    #0加分1减分
                    val INT,
    #数值
                    from_id INT,
    #处理人
                    to_id INT,
    #被处理人
                    create_time datetime
);

#公告表
CREATE TABLE notice (
                        id INT NOT NULL PRIMARY KEY auto_increment,
    #主键
                        uid INT NOT NULL,
    #用户id
                        theme CHAR (30),
    #主题
                        content text,
    #内容
                        create_time datetime #创建时间
);

#评论表
CREATE TABLE comment (
                         id INT NOT NULL PRIMARY KEY auto_increment,
    #主键
                         nid INT NOT NULL,
    #新闻id
                         from_id INT,
    #评论人
                         content text,
    #内容
                         create_time datetime #创建时间
);

#子评论表
CREATE TABLE comment_child (
                               id INT NOT NULL PRIMARY KEY auto_increment,
    #主键
                               cid INT NOT NULL,
    #新闻id
                               from_id INT,
    #评论人
                               to_id INT,
    #评论人
                               content text,
    #内容
                               create_time datetime #创建时间
);