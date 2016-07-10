/**
 * Sends DELETE request to CMS and removes page from list
 */
function deleteStaticPage(pageId)
{
    $.ajax({url:"/admin/pages/" + pageId, type:"DELETE", success: function(result)
    {
        $("#page-entry-" + pageId).remove();
    }});
}

/**
 * Changes publication status of specific page
 */
function setStaticPagePublished(pageId, value)
{
    $.post("/admin/pages/" + pageId, {"published": value});
}

/**
 * Disable or enable blog-post frame in specific page
 */
function setStaticPageFrame(pageId, value)
{
    $.post("/admin/pages/" + pageId, {"frame": value});
}