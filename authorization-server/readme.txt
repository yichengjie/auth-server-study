获取授权码：
    http://localhost:9090/oauth/authorize?client_id=clientapp&redirect_uri=http://localhost:9000/callback&response_type=code&scope=read_users

获取AccessToken：
    http://localhost:9090/oauth/token?code=hZDJ9w&grant_type=authorization_code&redirect_uri=http://localhost:9000/callback&scope=read_users
