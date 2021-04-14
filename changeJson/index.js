var fs = require("fs");
var obj = JSON.parse(
  fs.readFileSync("/Users/sunbose/TestWorkspace/test.json", "utf8")
);
var copy = [];
for (let i = 0; i < obj.length; i++) {
  let temp = {};
  temp = obj[i];
  temp.PersonId = 1 + i;
  temp.AssignmentId = 12 + i;
  temp.JobName = "";

  copy.push(temp);
}
fs.writeFileSync("test1.json", JSON.stringify(copy));
console.log(JSON.stringify(copy));
console.log(obj.length);
