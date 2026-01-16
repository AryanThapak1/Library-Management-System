export const guestNavigation = [
  { name: "Home", href: "/" },
  { name: "Login", href: "/login" },
];

export const userNavigation = [
  {
    name: "Search Books",
    href: "/search-book",
  },
  {
    name: "Requests",
    href: "/requests",
  },
  {
    name:"Chatbox",
    href:"/chatbox"
  },
  {
    name:"My Requests",
    href:"/my-requests"
  }
];

const adminOptions = [
  {
    name: "Dashboard",
    href: "/dashboard",
  },
  {
    name: "Student",
    href: "/student",
  },
  {
    name:"Add Book",
    href:"/addbook"
  }
];

export const adminNavigation = [...userNavigation, ...adminOptions];
