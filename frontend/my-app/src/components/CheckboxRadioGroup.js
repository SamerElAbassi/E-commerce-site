import { useState } from "react";
import { ButtonGroup } from "react-bootstrap";
import { RangeCheckbox } from "./RangeCheckbox";
export function CheckboxRadioGroup({ children, onFilterChange }) {
  const [checked, setChecked] = useState(-1);
  function onChange(e, id) {
    if (checked != id) {
      setChecked(id);
      onFilterChange(true, children[id]);
    } else {
      setChecked(-1);
      onFilterChange(false, children[id]);
    }
  }
  return (
    <ButtonGroup vertical>
      {children.map((child, index) => (
        <RangeCheckbox
          key={child + index + " radio"}
          label={child}
          name={child}
          onChange={onChange}
          checked={checked === index ? true : false}
          id={index}
        />
      ))}
    </ButtonGroup>
  );
}
