import axios from "axios";
export const fetchItems = async (url) => {
  const res = await axios.get(url);
  return res;
};
