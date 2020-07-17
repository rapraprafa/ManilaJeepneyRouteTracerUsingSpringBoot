<?php
    if ($_POST['report']) {
        mysql_connect ("sql12.freemysqlhosting.net", "sql12286772", "qDpvgqB9k8") or die ('Error: ' . mysql_error());
        mysql_select_db("sql12286772") or die ('Data error:' . mysql_error());
        $text = mysql_real_escape_string($_POST['report']); 
        $query="INSERT INTO reportlog (player_data) VALUES ('$text')";
        mysql_query($query) or die ('Error updating database' . mysql_error());
    }
?>


<form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
    <textarea name="report" placeholder="Type your report..."></textarea>
    <input name="submit" type="submit" value="submit" />
</form>