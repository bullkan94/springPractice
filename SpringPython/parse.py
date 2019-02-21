import urllib
import urllib.request
import urllib.parse
import json
import db
from datetime import datetime

apiUrl = "https://openapi.naver.com/v1/search/news.json"
myID = "ID"
myToken = "TOKEN"

def printJ(dict):
	for h in dict:
		print(h + " : " + str(dict[h]))

def getQuery(data):
	query = ""
	query += "?query=" + data
	query += "&display=20&start=1&sort=date"
	return query

def request(data):
	try:
		req = urllib.request.Request(url = apiUrl + getQuery(data), method = "GET")
#		req.add_header('Content-Type', 'application/json')
		req.add_header('X-Naver-Client-Id', myID)
		req.add_header('X-Naver-Client-Secret', myToken)
		urlTicker = urllib.request.urlopen(req)
	except urllib.error.HTTPError as err:
		print(err)
		exit(0)

	readTicker = urlTicker.read()
	return json.loads(readTicker.decode('utf-8'))

def onCall(data):
	url = apiUrl + "/oncalls"
	return request(data)

rawdata = onCall('api')
for items in rawdata['items']:
	title = items['title']
	link = items['link']
	date = datetime.strptime(items['pubDate'], "%a, %d %b %Y %H:%M:%S +0900")
	pubDate = date.strftime("%Y%m%d%H%M%S")
	db.insertInto(title, link, pubDate)
