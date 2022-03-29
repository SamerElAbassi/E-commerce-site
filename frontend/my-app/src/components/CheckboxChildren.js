import { Form, FormGroup } from "react-bootstrap";
import { CheckboxRadioGroup } from "./CheckboxRadioGroup";
import { RangeCheckbox } from "./RangeCheckbox";
import { ValueCheckbox } from "./ValueCheckbox";
import { SelectableValueGroup } from "./SelectableValueGroup";
import { SelectableButtonGroup } from "./SelectableButtonGroup";
import { RangeSlider } from "./RangeSlider";
const titleToComponent = {
  color: "valueGroup",
  sizes: "buttonGroup",
  price: "rangeGroup",
};
export default function CheckboxChildren({ title, onFilterChange, children }) {
  switch (titleToComponent[title]) {
    case "buttonGroup":
      return (
        <SelectableButtonGroup children={children} onClick={onFilterChange} />
      );
    case "rangeGroup":
      return <RangeSlider children={children} onClick={onFilterChange} />;
    default:
      return (
        <SelectableValueGroup
          children={[...new Set(children.map((x) => x.toLowerCase()))]}
          onClick={onFilterChange}
        />
      );
  }
}
