      program Gauss
      real A(3,4)
      real max, vmax, wmax
      integer u, x, y, z
      u = 12



      open (u, FILE='gaussFile.dat', STATUS='OLD')
         do i = 1, 3
            read(u,*) A(i,1), A(i,2), A(i,3), A(i, 4)
            write(*,*) A(i,1), A(i,2), A(i,3), A(i, 4)
         enddo
      close(u)

      
      if (A(2,1) .NE. vmax) then
         vmax = A(2,1) / A(1,1)
         do i = 2, 4
            wmax = A(2,i)
            max = vmax * A(1, i)
            A(2,i) = wmax - max
            
         end do
         A(2,1) = 0
      end if
      
      vmax = 0
      
      if (A(3,1) .NE. vmax) then
         vmax = A(3,1) / A(1,1)
         do i = 2, 4
            wmax = A(3,i)
            max = vmax * A(1, i)
            A(3,i) = wmax - max
           
         end do
         A(3,1) = 0
      end if

      print*,"Final"

      do i = 1, 3
         print*, A(i,1), A(i,2), A(i,3), A(i, 4)
      end do

      vmax = 0
      
      if (A(3,2) .NE. vmax) then
         vmax = A(3,2) / A(2,2)
         do i = 3, 4
            wmax = A(2,i)
            max = vmax * A(2,i)
            A(3,i) = A(3,i) - max
            
         end do
         A(3,2) = 0
      end if
      
      x = A(3,4)/A(3,3)

      max = A(2,3) * x
      vmax = A(2,4) - max
      y = vmax/A(2,2)

      max = A(1,3) * x
      vmax = A(1,2) * y
      wmax = A(1,4) - max
      wmax = wmax - vmax
      z = wmax/A(1,1)
      

      print*,"Answer", x, y, z
      
      do i = 1, 3
         print*, A(i,1), A(i,2), A(i,3), A(i, 4)
      end do
      

9999 stop
     end