SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Employee](
    [employeeId] [int] IDENTITY(1,1) NOT NULL,
    [name] [varchar](200) NOT NULL,
    [salary] [float] NOT NULL,
    [age] [float] NOT NULL,
    [yearsInCompany] [float] NULL,
    CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED
(
[employeeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, FILLFACTOR = 90) ON [PRIMARY]
    ) ON [PRIMARY]

    GO

    SET ANSI_PADDING OFF
    GO