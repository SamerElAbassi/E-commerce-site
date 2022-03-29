import Slider from "@mui/material/Slider";
import { useState } from "react";
import CheckboxCategory from "./CheckboxCategory";
export function PriceFilter({ min, max, chunkNum, onFilterChange }) {
  function getRangeChunks(min, max, chunkNum) {
    let ranges = [];
    const step = parseFloat((max - min) / chunkNum).toFixed(2);
    for (let i = 0; i < chunkNum; i++) {
      ranges.push([
        parseFloat(min) + step * i,
        parseFloat(min) + step * (i + 1),
      ]);
    }
    ranges = ranges.map((x, y) => [x[0].toFixed(2), x[1].toFixed(2)]);
    ranges[ranges.length - 1][1] = parseFloat(max).toFixed(2);
    return ranges;
  }
  return (
    <CheckboxCategory
      title="Price"
      children={getRangeChunks(min, max, chunkNum)}
      onFilterChange={onFilterChange}
      type="range"
    ></CheckboxCategory>
  );
}
