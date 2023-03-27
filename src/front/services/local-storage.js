
function $salvar(key, data) {
  localStorage.setItem(key, JSON.stringify(data));
}

function $deletar(key) {
  localStorage.removeItem(key);
}
