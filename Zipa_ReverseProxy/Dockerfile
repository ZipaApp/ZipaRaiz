FROM nginx:stable-alpine

# Copy nginx config (kept in the same folder)
COPY nginx.conf /etc/nginx/nginx.conf

# Start nginx in foreground
CMD ["nginx", "-g", "daemon off;"]
