<template src="./Landscape.html"></template>

<script lang="ts" src="./Landscape.component.ts"></script>

<style scoped>
.jhipster-landscape-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
  flex-wrap: wrap;
}

.jhipster-landscape-search-container {
  flex-grow: 1;
  display: flex;
  justify-content: center;
  margin: 0 20px;
}

.jhipster-landscape-search {
  display: flex;
  align-items: center;
  background-color: white;
  padding: 10px;
  border-radius: 20px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  max-width: 400px;
  width: 100%;
}

.jhipster-landscape-search .jhlite-field--field {
  flex-grow: 1;
}

.jhipster-landscape-search .jhlite-input-text {
  width: 100%;
  padding: 8px 12px;
  border: 1px solid #ccc;
  border-radius: 20px;
}

.jhipster-landscape-search-close {
  background-color: #f44336;
  color: white;
  border: none;
  border-radius: 50%;
  width: 24px;
  height: 24px;
  font-size: 16px;
  line-height: 1;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0;
  margin-left: 10px;
}

.jhipster-landscape-search-close:hover {
  background-color: #d32f2f;
}

.jhlite-menu-content-template--content {
  display: flex;
  flex-direction: column;
}

.-search-highlighted {
  position: relative;
  box-shadow: 
    0 0 0 3px #ffd700,
    0 0 0 6px rgba(255, 215, 0, 0.5);
  z-index: 1;
  background-color: rgba(255, 215, 0, 0.1);
  animation: pulse 2s infinite;
}

@keyframes pulse {
  0% {
    box-shadow: 
      0 0 0 3px #ffd700,
      0 0 0 6px rgba(255, 215, 0, 0.7);
  }
  70% {
    box-shadow: 
      0 0 0 3px #ffd700,
      0 0 0 12px rgba(255, 215, 0, 0);
  }
  100% {
    box-shadow: 
      0 0 0 3px #ffd700,
      0 0 0 6px rgba(255, 215, 0, 0);
  }
}
</style>
