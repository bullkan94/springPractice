import MySQLdb
def insertInto(title, link, pubDate):
    #INIT
    db = MySQLdb.connect(host = "localhost",
    	user = "USER",
    	passwd = "PASS",
    	db = "DBNAME",
        charset='utf8')
    cur = db.cursor()

    #Check duplicate
    query = "select count(*) from news where link='%s'" % (link)
    cur.execute(query.encode())

    result = cur.fetchone()

    if result[0] == 0:
        #Insert article
        query = """insert into news (title, link, pubDate) values ("%s", "%s", %s)""" %(title, link, pubDate)
        cur.execute(query.encode())
    else :
        print("That article is already exist")

    #Mission Over
    db.commit()
    db.close()