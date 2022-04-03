~/clean_git.sh
set -x
uuid=$(uuidgen)
touch "$uuid".txt
git add --all
git commit -m "NEW: $uuid created"
git push origin HEAD:refs/for/develop%topic=$1

