$(async function() {
    await thisUser();
});
async function thisUser() {
    fetch("http://localhost:8080/api/user")
        .then(res => res.json())
        .then(data => {
            // Добавляем информацию в шапку
            $('#headerName').append(data.name);
            let roles = data.roles.map(role => " " + role.name.substring(5));
            $('#headerRoles').append(roles);

            //Добавляем информацию в таблицу
            let user = `$(
            <tr>
                <td>${data.id}</td>
                <td>${data.name}</td>
                <td>${data.lastName}</td>
                <td>${data.department}</td>
                <td>${data.salary}</td>
                <td>${data.username}</td>
                <td>${roles}</td>)`;
            $('#userPanelBody').append(user);
        })
}



