
git checkout -b "signed-branch"

echo foo > bar.txt

git add .
git commit -S -m "This commit is signed!"
git push
