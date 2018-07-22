#### mysql install 
1. docker pull mysql:5.7.18
2. docker run -d -p 3306:3306 -v /soft/mysql/my.cnf:/etc/mysql/mysql.conf.d/mysqld.cnf -v /soft/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 --name mymysql mysql:5.7.18
 