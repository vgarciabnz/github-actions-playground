
BRANCH="signed-branch"
git checkout -b $BRANCH

echo foo > bar.txt

git add .
git commit -S -m "This commit is signed!"
git push origin $BRANCH
