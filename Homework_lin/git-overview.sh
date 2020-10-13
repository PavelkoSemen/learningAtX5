#!/bin/bash

current_path="$(pwd)/.git"

function counts_commit(){
    if [[ "$1" && "$1" =~ [0-9]+$ ]]; then
        git log --pretty=oneline --since="$1".week| wc -l
    else
        git log --pretty=oneline | wc -l
    fi
}

function list_surname(){
    git log --pretty=format:"%an" --since=1.week | sort | uniq | sed 's/^/---->/'
}

[ ! -d "$current_path" ] && echo "Это не гид проект" && exit

current_date=$(date +"%H:%M %d.%m.%Y")

added_removed_rows=$(git log --pretty=short --numstat  --since=1.week | grep -E '^[0-9]+' | awk '{
    added_rows+=$1;
    removed_rows+=$2
} END{print added_rows,removed_rows}')

cat << _GI_
$current_date
All commits: $(counts_commit)
Commits in the last week: $(counts_commit 1)
Added and removed lines: $added_removed_rows
Made changes in the past week:
$(list_surname)
_GI_

exit 0