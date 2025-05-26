export default function Aside({ asideLinks = [] }) {
  return (
    <aside>
      <ul>
        {asideLinks.map((items, index) => {
          return (
            <li key={index}>
              <a href={items.href}> {items.title}</a>
            </li>
          );
        })}
      </ul>
    </aside>
  );
}
