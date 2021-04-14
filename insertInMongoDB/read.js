const MongoClient = require("mongodb").MongoClient;
var url = "mongodb://localhost:27017/";
MongoClient.connect(url, function (err, db) {
  var dbo = db.db("mydb");
  var cursor = dbo.collection("user").find();
  cursor.each(function (err, item) {
    if (item == null) {
      db.close();
      return;
    }
    console.log(item);
  });
});
