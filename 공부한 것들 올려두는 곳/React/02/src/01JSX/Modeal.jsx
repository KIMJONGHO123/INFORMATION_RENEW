import React from "react";

export default function CustomModal({ open, onClose }) {
  if (!open) {
    return null;
  }

  return (
    <>
      <h1>커스텀 모달창..</h1>
      <h2>이건 div만으로 만든거야</h2>
      <button onClick={onClose}>닫기</button>
    </>
  );
}
