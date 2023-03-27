const $baseUrl = "http://localhost:8080";

async function $post(path, data) {
  const response = await fetch($baseUrl + path, {
    method: "POST",
    body: JSON.stringify(data),
    headers: {
      "Content-Type": "application/json",
    },
  });
  return await response.json();
}

async function $get(path) {
  const response = await fetch($baseUrl + path, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  });
  return await response.json();
}

async function $delete(path) {
  const response = await fetch($baseUrl + path, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  });
  return await response.json();
}
