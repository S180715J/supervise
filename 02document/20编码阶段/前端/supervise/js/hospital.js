// api url



function getJwtToken() {
  return localStorage.getItem(TOKEN_KEY);
}

function setJwtToken(token) {
  localStorage.setItem(TOKEN_KEY, token);
}

function removeJwtToken() {
  localStorage.removeItem(TOKEN_KEY);
}

function createAuthorizationTokenHeader() {
  var token = getJwtToken();
  // console.log(token)
  if (token) {
    return {"Authorization": "Bearer " + token};
  } else {
    return {};
  }
}

/**
 * 快速的将 form 表单数据转为 json 格式
 * @param $form
 */
function getFormData($form) {
  var unindexed_array = $form.serializeArray()
  var indexed_array = {}

  $.map(unindexed_array, (n, i) => {
    indexed_array[n['name']] = n['value']
  })

  return indexed_array
}