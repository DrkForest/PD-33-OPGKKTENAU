<#import "parts/common.ftl" as htmlBase>
<#import "parts/login.ftl" as loginBase>

<@htmlBase.page>
    <div>
        <@loginBase.logout/>
    </div>


    <div>

        <form method="post">
            <input type="text" name="text" placeholder="Enter note text...">
            <input type="date" name="date" >
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Post</button>
        </form>
    </div>

    <div>Список заметок</div>
    <form method="get" action="/main">
        <input type="text" name="filter" value="${filter}" placeholder="Enter search text...">
        <button type="submit">Search</button>
    </form>
    <#list notes as note>
    <div>
        <b>${note.id}</b>
        <span>${note.text}</span>
        <i>${note.date}</i>
        <strong>${note.userName}</strong>
    </div>
    <#else>
        No message yet.
    </#list>
</@htmlBase.page>