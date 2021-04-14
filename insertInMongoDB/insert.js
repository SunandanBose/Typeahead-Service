const MongoClient = require("mongodb").MongoClient;
var url = "mongodb://localhost:27017/";
var fs = require("fs");

MongoClient.connect(url, function (err, db) {
  if (err) throw err;
  var dbo = db.db("mydb");
  var obj = JSON.parse(
    fs.readFileSync("/Users/sunbose/TestWorkspace/test.json", "utf8")
  );
  var data = [];
  for (let i = 0; i < obj.length; i++) {
    data.push(obj[i]);
  }
  dbo.collection("user").insertMany(data, function (err, res) {
    if (err) throw err;
    console.log("Number of documents inserted: " + res.insertedCount);
    db.close();
  });
});
