import { Dialog, DialogTitle } from "@mui/material";
import { useState } from "react";
export function DialogAlert({ title, open, onClose }) {
  return (
    <Dialog open={open} onClose={() => onClose()}>
      <DialogTitle>{title}</DialogTitle>
    </Dialog>
  );
}
