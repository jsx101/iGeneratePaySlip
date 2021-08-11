(this.webpackJsonpfrontend=this.webpackJsonpfrontend||[]).push([[0],{26:function(e,t,n){},27:function(e,t,n){},50:function(e,t,n){"use strict";n.r(t);var a=n(2),r=n.n(a),c=n(20),i=n.n(c),s=(n(26),n(9)),o=(n(27),n(21)),l=n(52),u=n(53),j=n(54),d=n(55),b=n(56),p=n(1),h=n(29);var O=function(e){var t=e.sendDataToParent,n=Object(a.useState)({firstname:"",lastname:"",annualSalary:"",paymentMonth:"",superRate:""}),r=Object(s.a)(n,2),c=r[0],i=r[1],O=function(e){var t=Object(o.a)({},c);t[e.target.id]=e.target.value,i(t)};return Object(p.jsxs)(l.a,{children:[Object(p.jsx)("h2",{children:"Fill in employee details"}),Object(p.jsxs)(u.a,{onSubmit:function(e){return function(e){e.preventDefault(),c.superRate=c.superRate/100,h.post("/api/generate/pay-slip",c).then((function(e){i({firstname:"",lastname:"",annualSalary:"",paymentMonth:"",superRate:""}),t(e.data)}))}(e)},children:[Object(p.jsxs)(j.a,{children:[Object(p.jsx)(d.a,{for:"firstname",children:"First name"}),Object(p.jsx)(b.a,{type:"text",name:"firstname",id:"firstname",onChange:function(e){return O(e)},value:c.firstname,required:"required"})]}),Object(p.jsxs)(j.a,{children:[Object(p.jsx)(d.a,{for:"lastname",children:"Last name"}),Object(p.jsx)(b.a,{type:"text",name:"lastname",id:"lastname",onChange:function(e){return O(e)},value:c.lastname,required:"required"})]}),Object(p.jsxs)(j.a,{children:[Object(p.jsx)(d.a,{for:"annualSalary",min:"0",children:"Annual Salary ($)"}),Object(p.jsx)(b.a,{type:"number",name:"annualSalary",id:"annualSalary",onChange:function(e){return O(e)},value:c.annualSalary,required:"required"})]}),Object(p.jsxs)(j.a,{children:[Object(p.jsx)(d.a,{for:"paymentMonth",children:"Payment month"}),Object(p.jsxs)("select",{name:"paymentMonth",id:"paymentMonth",onChange:function(e){return O(e)},value:c.paymentMonth,required:"required",children:[Object(p.jsx)("option",{value:"",children:"SELECT"}),Object(p.jsx)("option",{value:"0",children:"January"}),Object(p.jsx)("option",{value:"1",children:"February"}),Object(p.jsx)("option",{value:"2",children:"March"}),Object(p.jsx)("option",{value:"3",children:"April"}),Object(p.jsx)("option",{value:"4",children:"May"}),Object(p.jsx)("option",{value:"5",children:"June"}),Object(p.jsx)("option",{value:"6",children:"July"}),Object(p.jsx)("option",{value:"7",children:"August"}),Object(p.jsx)("option",{value:"8",children:"September"}),Object(p.jsx)("option",{value:"9",children:"October"}),Object(p.jsx)("option",{value:"10",children:"November"}),Object(p.jsx)("option",{value:"11",children:"December"})]})]}),Object(p.jsxs)(j.a,{children:[Object(p.jsx)(d.a,{for:"superRate",children:"Superannuation rate (%)"}),Object(p.jsx)(b.a,{type:"",name:"superRate",id:"superRate",min:"0",step:"0.1",onChange:function(e){return O(e)},value:c.superRate,required:"required"})]}),Object(p.jsx)(b.a,{type:"submit",value:"Generate"}),Object(p.jsx)(b.a,{type:"reset",value:"Clear"})]})]})};var m=function(e){var t=e.data,n=e.backToFormFunction,a=t.employee,r=t.grossIncome,c=t.incomeTax,i=t.netIncome,s=t.superannuation,o=t.paymentStartDate,l=t.paymentEndDate,u=a.firstname,j=a.lastname,d=a.superRate;return Object(p.jsxs)("div",{"data-testid":"pay-slip-data",children:[Object(p.jsxs)("div",{children:["Employee's name: ",u+" "+j]}),Object(p.jsxs)("div",{children:["Pay period: ",o+" \u2014 "+l]}),Object(p.jsxs)("div",{children:["Net income: $",i]}),Object(p.jsxs)("div",{children:["Gross income: $",r]}),Object(p.jsxs)("div",{children:["Income tax: $",c]}),Object(p.jsxs)("div",{children:["Superannuation: $",s+" (".concat(100*d,"%)")]}),Object(p.jsx)("button",{"data-testid":"paySlipDisplay-back-button",onClick:function(){n()},children:"Back"})]})};var x=function(){var e=Object(a.useState)(null),t=Object(s.a)(e,2),n=t[0],r=t[1],c=function(e){r(e),console.log("Pay slip generated")},i=function(){r(null),console.log("Back to the form")},o=Object(a.useState)(Object(p.jsx)(O,{sendDataToParent:c})),l=Object(s.a)(o,2),u=l[0],j=l[1];return Object(a.useEffect)((function(){j(n?Object(p.jsx)(m,{data:n,backToFormFunction:i}):Object(p.jsx)(O,{sendDataToParent:c}))}),[n]),Object(p.jsx)("div",{"data-testid":"app",className:"App",children:u})},f=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,57)).then((function(t){var n=t.getCLS,a=t.getFID,r=t.getFCP,c=t.getLCP,i=t.getTTFB;n(e),a(e),r(e),c(e),i(e)}))};i.a.render(Object(p.jsx)(r.a.StrictMode,{children:Object(p.jsx)(x,{})}),document.getElementById("root")),f()}},[[50,1,2]]]);
//# sourceMappingURL=main.771302ff.chunk.js.map