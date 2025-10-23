cd "$(dirname "$0")"

mvn -P liquibase liquibase:update

read -p "Press Enter to continue..."
