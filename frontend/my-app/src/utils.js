export function stripNum(str) {
  return parseFloat(str.replace("$", ""));
}
export function convertValueOrRange(child) {
  return typeof child == "string" ? child : child[0] + "-" + child[1];
}
export function convertChildrenQuery(filter) {
  if (filter["type"] === "range")
    return filter["children"][0] + "-" + filter["children"][1];
  if (filter["type"] === "value") return filter["children"];
}
export function dateToText(dateStr) {
  const [day, month, year] = dateStr.split("/");
  console.log(year);
  var date = new Date(year, month, day);
  return date.toLocaleDateString("en-US", {
    weekday: "long",
    month: "long",
    day: "numeric",
  });
}
